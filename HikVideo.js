import React, { Component } from 'react';
import { requireNativeComponent, View } from 'react-native';
import PropTypes from 'prop-types';

export default class HikVideo extends React.Component {
  static propTypes = {
    ...View.propTypes,
    source: PropTypes.object.isRequired
  };

  render() {
    return <RCTView {...this.props} />;
  }
}

const RCTView = requireNativeComponent('HikVideoView', HikVideo, {
  nativeOnly: { onChange: true }
});
