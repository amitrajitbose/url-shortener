import React, { useState, useEffect, Suspense, useRef } from "react";

import Loader from "./components/Loader";
import Footer from "./components/Footer";
import Maintenance from "./components/Maintenance";

import "./App.css";

const List = React.lazy(() => import('./components/List'));

function App() {

    const BASE_URL = "https://ur-l.herokuapp.com";
    const form = useRef(null);
    const [submitting, setSubmitting] = useState(false);
    const [shortUrls, setShortUrl] = useState([]);
    const [maintenance, setMaintenance] = useState(false);
    
    const createUrl = async (event) => {
        setSubmitting(true)
        event.preventDefault();
        const url = "/api/v1/";
        let custom = event.target[1].value ? true : false;
        const payload = {
            url: event.target[0].value,
            custom: custom,
        };
        if (custom) {
            payload.shortKey = event.target[1].value
        }
        try {
            const response = await fetch(`${BASE_URL}${url}`, {
                headers: {
                    "Content-Type": "application/json",
                },
                method: "POST",
                body: JSON.stringify(payload),
            });
            const data = await response.json();
            if (data.shortKey) {
                form.current.reset();
                setShortUrl(prevState => [...prevState, `${BASE_URL}/${data.shortKey}`])
            } else {
                alert(data.message ? data.message : "Something Went Wrong");
            }
            setSubmitting(false)
        } catch (err) {
            setSubmitting(false)
            alert(`${err}`);
        }
    };

    useEffect(() => {
        checkHealth()
    }, [])

    const checkHealth = async () => {
        const url = `${BASE_URL}/api/v1/health`;
        try {
            const res = await fetch(url)
            if (res.status !== 200) {
                setMaintenance(true)
            } else {
                setMaintenance(false)
            }
        } catch (e) {
            setMaintenance(true)
        }
    }

    return (
        <div className="App">
            {maintenance ?
                <Maintenance /> :
                <>
                    <form className="url-form" ref={form} onSubmit={createUrl}>
                        <div className="url-form-header">
                            {submitting ?
                                <Loader /> :
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="#323b40" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="feather feather-link-2"><path d="M15 7h3a5 5 0 0 1 5 5 5 5 0 0 1-5 5h-3m-6 0H6a5 5 0 0 1-5-5 5 5 0 0 1 5-5h3"></path><line x1="8" y1="12" x2="16" y2="12"></line></svg>
                            }
                        </div>
                        <input
                            type="url"
                            placeholder="URL to be shortened"
                            required
                        />
                        <input type="text"
                            placeholder="Custom Key (Optional)"
                            pattern="^[a-zA-Z0-9]{1,16}$"
                        />
                        <button className="btn" disabled={submitting} type="submit">
                            Shorten
                        </button>
                    </form>
                    {shortUrls.length > 0 &&
                        <section className="url-section">
                            <ul className="number-list">
                                <Suspense fallback={<p> LOADING... </p>}>
                                    <List items={shortUrls} />
                                </Suspense>
                            </ul>
                        </section>
                    }
                </>
            }
            <Footer />
        </div>
    );
}

export default App;
