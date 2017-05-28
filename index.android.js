/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';

import { NativeModules } from 'react-native';
ToastAndroid = NativeModules.CustomToastAndroid;

export default class firstReact extends Component {
  render() {

    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started
        </Text>
        <TouchableOpacity onPress={
          () => {
            ToastAndroid.show('Awesome', ToastAndroid.SHORT);
          }
        }>
          <Text>Test</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

import { task } from './bgTask';

AppRegistry.registerComponent('firstReact', () => firstReact);
console.log("-----------------------------------");
AppRegistry.registerHeadlessTask('SomeTaskName', () => task);
