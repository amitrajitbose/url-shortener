import React from 'react';
import PropTypes from 'prop-types';
import ListItem from '../ListItem';

import './style.css';

const List = ({ items }) => (
  <ul className="number-list">
    { items.slice(Math.max(items.length - 6, 0)).map((item) => (
      <ListItem item={item} key={item} />
    ))}
  </ul>
);

List.propTypes = {
  // eslint-disable-next-line react/forbid-prop-types
  items: PropTypes.any.isRequired,
};

export default List;
