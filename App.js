import React, { Component } from 'react';
import { Text, View } from 'react-native';

import ToastExample from './element';

ToastExample.show('dafsd', ToastExample.SHORT);

export default class HelloWorldApp extends Component {
  render() {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <Text>Chang, Hello World 是收到按时 修改一下!</Text>
      </View>
    );
  }
}
