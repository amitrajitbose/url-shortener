import React, { useState } from "react";

import Loader from "./components/Loader";
import Footer from "./components/Footer";

import "./App.css";

function App() {

  const BASE_URL = "https://ur-l.herokuapp.com";

  const createUrl =   async (event) => {
    setSubmitting(true)
    event.preventDefault();
    const url = "/api/v1/";
    let custom = event.target[1].value ? true : false;
    const payload = {
      url: event.target[0].value,
      custom: custom,
    };
    if(custom) {
      payload.shortKey = event.target[1].value
    }
    try {
      const response = await fetch( `${BASE_URL}${url}`, {
        headers: {
          "Content-Type": "application/json",
        },
        method: "POST",
        body: JSON.stringify(payload),
      });
      const data = await response.json();
      if(data.shortKey) {
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

  const [submitting, setSubmitting] = useState(false);
  const [shortUrls, setShortUrl] = useState([])


  return (
    <div className="App">
      
      <form className="url-form" name="url-form" onSubmit={createUrl}>
        { submitting ?
          <Loader /> :
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="#323b40" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="feather feather-link-2"><path d="M15 7h3a5 5 0 0 1 5 5 5 5 0 0 1-5 5h-3m-6 0H6a5 5 0 0 1-5-5 5 5 0 0 1 5-5h3"></path><line x1="8" y1="12" x2="16" y2="12"></line></svg>
        } 
        <input
          type="url"
          placeholder="Please Enter an URL to be shortened"
          required
        />
        <input type="text"
          placeholder="Custom Key (1-6) Long"
          pattern="^[a-zA-Z0-9]{1,}$"
        />
        <button className="btn" disabled={submitting} type="submit">
          Shorten
        </button>
      </form>
      {shortUrls.length > 0 && 
        <section>
          <ul className="number-list">
            { shortUrls.map(url =>(
              <li className="number-list-item">
                <a href={url} target="_blank" rel="noopener noreferrer">{url}</a>
              </li>
            ))}
          </ul>
        </section>
      }
      <Footer />
    </div>
  );
}

export default App;
