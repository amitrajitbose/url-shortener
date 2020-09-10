import React from 'react';
import PropTypes from 'prop-types';

import './style.css';

const ListItem = ({ item }) => (
  <li className="number-list-item">
    <a href={item} target="_blank" rel="noopener noreferrer">{item}</a>
  </li>
);

ListItem.propTypes = {
  item: PropTypes.string.isRequired,
};

export default ListItem;
