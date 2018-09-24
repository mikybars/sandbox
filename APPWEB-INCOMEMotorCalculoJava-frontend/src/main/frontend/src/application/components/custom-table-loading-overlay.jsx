import "@/application/assets/css/styles.css";
import React from "react";
import PropTypes from "prop-types";
import { Icon } from "amiga-core/components/basic";

const CustomTableLoadingOverlay = ({ text }) => (
  <div className="custom_grid_overlay--container">
    <div className="custom_grid_overlay--icon-container">
      <Icon name="circle-o-notch" spin size="xxl" />
    </div>
    <h3>{text}</h3>
  </div>
);

CustomTableLoadingOverlay.propTypes = {
  text: PropTypes.string,
};

export default CustomTableLoadingOverlay;
