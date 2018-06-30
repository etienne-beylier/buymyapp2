import React, { Component } from 'react';
import { connect } from 'react-redux';
import LoginScreen from './LoginScreen';
import HomeScreen from './HomeScreen';
 
class AuthScreen extends Component {
    render() {
        if (this.props.isLoggedIn == "LOGIN") {
            return <HomeScreen />;
        } else {
            return <LoginScreen />;
        }
    }
}
 
const mapStateToProps = (state, ownProps) => {
    return {
        isLoggedIn: state.auth.isLoggedIn
    };
}
 
export default connect(mapStateToProps)(AuthScreen);
