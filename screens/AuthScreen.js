import React, { Component } from 'react';
import { connect } from 'react-redux';
import LoginScreen from './LoginScreen';
import SecuredScreen from './SecuredScreen';
import MainScreen from './MainScreen';
 
class AuthScreen extends Component {
    render() {
        if (this.props.isLoggedIn == "LOGIN") {
            console.log(this.props.isLoggedIn);
            console.log("kejdzlakjelkzajekl");
            return <MainScreen />;
        } else {
            console.log(this.props.isLoggedIn);
            console.log(this.props.username);
            console.log("dddd");
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
