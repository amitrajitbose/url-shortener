import React, { useState, useEffect } from "react";

import Loader from "./components/Loader";

import logo from "./logo.svg";
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
        setResponse(`${BASE_URL}/${data.shortKey}`);
      } else {
        setResponse(false);
        alert(data.message ? data.message : "Something Went Wrong");
      }
      setSubmitting(false)
    } catch (err) {
      setSubmitting(false)
      setResponse(false);
      alert(`${err}`);
    }
  };

  const [submitting, setSubmitting] = useState(false);
  const [response, setResponse] = useState(false);
  const [showResponse, setShowResponse] = useState(false);

  useEffect(() => {
    setShowResponse(response ? true : false);
  }, [response]);

  return (
    <div className="App">
      <form className="url-form" name="url-form" onSubmit={createUrl}>
        { submitting ?
          <Loader /> :
          <img src={logo} className="logo" alt="" />
        } 
        <input
          type="url"
          placeholder="Please Enter an URL to be shortened"
          required
        />
        <input type="text"
          placeholder="Custom Key (1-6) Long"
          pattern="^[a-zA-Z0-9]{1,6}$"
        />
        <button className="btn" disabled={submitting} type="submit">
          Submit
        </button>
        {showResponse && 
          <a href={response} target="_blank" rel="noopener noreferrer" className="response-box">{response}</a>
        }
      </form>
    </div>
  );
}

export default App;
