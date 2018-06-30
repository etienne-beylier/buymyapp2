import React, { Component } from 'react';
import { Provider } from 'react-redux';
import { createStackNavigator } from 'react-navigation';

import store from './store';
import MainScreen from './screens/MainScreen';
import AuthScreen from './screens/AuthScreen';

export default class App extends Component {
  render() {
      const MainNavigator = createStackNavigator({
        Auth: { screen: AuthScreen }
      });

    return (
      <Provider store={store}>
        <MainNavigator />
      </Provider>
    );
  }
}