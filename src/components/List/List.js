import React from 'react';
import ListItem from "../ListItem";

import "./style.css"

const List = ({items}) => {
  return (
    <ul className="number-list">
      { items.slice(Math.max(items.length - 6, 0)).map((item, index) =>(
        <ListItem item={item} key={index} />
      ))}
    </ul>
  )
}

export default List;