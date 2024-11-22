import React, { Component } from 'react';
import { requireNativeComponent, View, UIManager, findNodeHandle } from 'react-native';
import PropTypes from 'prop-types';

const RCT_VIDEO_REF = 'HikVideoView';

const NVR_CONROL = {
  PAUSE: 3,
  RESTART: 4,
  SPEED: 5,
  SLOW: 6,
};

export default class HikVideo extends React.Component {
  static propTypes = {
    ...View.propTypes,
    mode: PropTypes.string,
    source: PropTypes.object.isRequired,
  };

  constructor(props) {
    super(props);
    this._onChange = this._onChange.bind(this);
  }

  ptzControl(ptz, stop, speed) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.ptzControl,
      [ptz, stop, speed],
    );
  }

  capturePicture(fileName) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.capturePicture,
      [fileName],
    );
  }

  /**
   * playNVRBack('2020-04-20 13:10', '2020-04-20 13:20');
   * @param {*} startTime
   * @param {*} stopTime
   */
  playNVRBack(startTime, stopTime) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.playNVRBack,
      [startTime, stopTime],
    );
  }

  /**
   * controlNVRBack(3); // 暂停播放
   * controlNVRBack(4); // 恢复播放
   * controlNVRBack(5); // 快进
   * controlNVRBack(6); // 慢放
   * @param {*} code
   */
  controlNVRBack(code) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.controlNVRBack,
      [NVR_CONROL[code]],
    );
  }

  stopNVRBack() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.HikVideoView.Commands.stopNVRBack,
      [],
    );
  }

  _onChange(event) {
    if (!this.props.onChange) {
      return;
    }
    this.props.onChange(event.nativeEvent);
  }

  render() {
    const props = {
      mode: 'realplay',
      ...this.props,
    };
    return <RCTView ref={RCT_VIDEO_REF} {...props} onChange={this._onChange} />;
  }
}

const RCTView = requireNativeComponent('HikVideoView', HikVideo, {
  nativeOnly: { onChange: true },
});
