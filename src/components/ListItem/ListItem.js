import React from 'react';

import "./style.css"

const List = ({item}) => {
  return (
    <li className="number-list-item">
      <a href={item} target="_blank" rel="noopener noreferrer">{item}</a>
    </li>
  )
}

export default List;