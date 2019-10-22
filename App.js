import React, { Component } from 'react';
import { Text, View, Button, Alert } from 'react-native';

// import { ToastExample, CfcaModule } from './element';
import { ToastExample, CfcaModule } from './element';

ToastExample.show('dafsd', ToastExample.SHORT);

export default class HelloWorldApp extends Component {
  constructor(props) {
    super(props);
    this.state = { ret: '' };
  }

  _onPressButton = () => {
    CfcaModule.requestHKEServerRandom('你好', '0', '0', '0', '0', (e) => {
      console.log('e', e);
      const ret = `requestHKEServerRandom的结果 ${e}`;
      Alert.alert(ret);
      this.setState({ ret });
      // ToastExample.show(`requestHKEServerRandom的结果 ${e}`, ToastExample.SHORT);
    });
  };

  render() {
    const { ret } = this.state;
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <Text>{ret} Chang, Hello World 是收到按时 修改一下!</Text>
        <Button title="试试cfca" onPress={this._onPressButton}></Button>
      </View>
    );
  }
}
