import React from 'react';

import "./style.css";

import {ReactComponent as MaintenanceLogo} from '../../images/cloud.svg';

const Maintenance = () => {
  return (
    <>
      <MaintenanceLogo />
      <div className="message-box">
        <p>Our servers are tired and sleeping. As a free service we do not guarantee 100% uptime.</p>
        <p>Please reload after a few seconds.</p>
      </div>
    </>
  )
} 

export default Maintenance;