import React, { Component } from "react";
import { connect } from "react-redux";
import { Text, TextInput, View, Button, StyleSheet } from "react-native";
import { login, signup } from "../actions/auth";
import { FetchExample } from '../components/FetchApi';

class LoginScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      route: "Login",
      username: "",
      password: ""
    };
  }

  fetchApi(){
    return fetch('http://192.168.1.12:8080/user/all')
      .then((response) => response.json())
      .then((responseJson) => {

          console.log(responseJson);

      })
      .catch((error) =>{
        console.error(error);
      });
  }

  userLogin(e) {
    if (this.state.route == "Login") {
      this.fetchApi();
      this.props.onLogin(this.state.username, this.state.password);
    } else if (this.state.route == "SignUp") {
      this.props.onSignUp(this.state.username, this.state.password);
    }
    e.preventDefault();
  }

  toggleRoute(e) {
    let alt = this.state.route === "Login" ? "SignUp" : "Login";
    this.setState({ route: alt });
    e.preventDefault();
  }

  render() {
    let alt = this.state.route === "Login" ? "SignUp" : "Login";
    return (
      <View style={styles.container}>
        <View style={styles.navBar}>
          <Text style={styles.navBarHeader}>Please Login</Text>
        </View>
        <View style={styles.content}>
          <View>
            <Text style={styles.label}>Username</Text>
            <TextInput
              style={styles.textinput}
              placeholder="Username"
              autoCapitalize="none"
              autoCorrect={false}
              keyboardType="email-address"
              value={this.state.username}
              onChangeText={text => this.setState({ username: text })}
            />
            <Text style={styles.label}>Password</Text>
            <TextInput
              style={styles.textinput}
              placeholder="Password"
              autoCapitalize="none"
              autoCorrect={false}
              secureTextEntry={true}
              value={this.state.password}
              onChangeText={text => this.setState({ password: text })}
              secureTextEntry
            />
            <Button
              title="Login"
              onPress={e => this.userLogin(e)}
              title={this.state.route}
            />
            <Text
              style={{ fontSize: 16, color: "blue" }}
              onPress={e => this.toggleRoute(e)}
            >
              {alt}
            </Text>
          </View>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff"
  },
  navBar: {
    flexDirection: "row",
    paddingTop: 25,
    marginBottom: 20,
    height: 64,
    backgroundColor: "#1EAAF1"
  },
  navBarHeader: {
    flex: 1,
    color: "#FFFFFF",
    fontWeight: "bold",
    textAlign: "center"
  },
  content: {
    flex: 1,
    paddingLeft: 15,
    paddingRight: 15
  },
  label: {
    color: "#333",
    fontSize: 16,
    marginTop: 15
  },
  textinput: {
    alignSelf: "stretch",
    height: 40,
    borderColor: "white",
    fontSize: 16
  }
});

const mapStateToProps = (state, ownProps) => {
  return {
    isLoggedIn: state.auth.isLoggedIn
  };
};

const mapDispatchToProps = dispatch => {
  return {
    onLogin: (username, password) => {
      dispatch(login(username, password));
    },
    onSignUp: (username, password) => {
      console.log(username);
      dispatch(signup(username, password));
    }
  };
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(LoginScreen);
