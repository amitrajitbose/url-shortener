import React, { useState, useEffect } from 'react';
import logo from "./logo.svg";
import './App.css';

function App() {

  const createUrl = async (event) => {
    event.preventDefault();
    const url = "http://localhost:8080/api/v1/";
    const payload = {
      longUrl: event.target[0].value,
      custom: false
    }
    try {
      const response = await fetch(url, {
        method: 'POST',
        body: payload
      })
      const data = await response.json()
      console.log(data)
      setResponse(data.shortKey)
    } catch(err) {
      setResponse(null)
      alert(`${err}`)
    }
  }

  const [response, setResponse] = useState(null)
  const [showResponse, setShowResponse] = useState(false)

  useEffect(() => {
    if(response) {
      setShowResponse(!showResponse)
    }
  }, [response])

  return (
    <div className="App">
      <form className="url-form" name="url-form" onSubmit={createUrl}>
        <img src={logo} className="logo" alt=""/>
        <input type="url"  placeholder="Please Enter an URL to be shortened" required />
        <input className="btn" type="submit"/>
        { showResponse && 
          <p className="response-box">{response}</p>
        }
      </form>
    </div>
  );
}

export default App;
