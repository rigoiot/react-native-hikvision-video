import React, { Component } from 'react';
import { requireNativeComponent, View, UIManager, findNodeHandle } from 'react-native';
import PropTypes from 'prop-types';

const RCT_VIDEO_REF = 'HikVideoView';
export default class HikVideo extends React.Component {
  static propTypes = {
    ...View.propTypes,
    source: PropTypes.object.isRequired
  };

  ptzControl(ptz, stop) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.ptzControl,
      [ptz, stop]
    );
  }

  render() {
    return <RCTView ref={RCT_VIDEO_REF} {...this.props} />;
  }
}

const RCTView = requireNativeComponent('HikVideoView', HikVideo, {
  nativeOnly: { onChange: true }
});
