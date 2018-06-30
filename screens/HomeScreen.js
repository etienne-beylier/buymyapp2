import React from "react";
import { Text, View, Button, TextInput } from "react-native";
import { StyleSheet } from "react-native";
import SwipeableList from "../components/SwipeableList";

class HomeScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {text: '', data: [{"key": "bob"}, {"key": "tod"}]};
  }

  componentDidMount() {
    return fetch("http://192.168.1.12:8080/user/all")
      .then(response => response.json())
      .then(responseJson => {
        this.setState(
          {
            isLoading: false,
            dataSource: responseJson.movies
          },
          function() {}
        );
      })
      .catch(error => {
        console.error(error);
      });
  }

  forceUpdateHandler() {
    this.forceUpdate();
  }

  onPress(text) {
    this.state.data.push({ key: text });
  }

  render() {
    return (
      <View style={styles.notContainer}>
        <TextInput
          style={{height: 40, backgroundColor: 'white'}}
          placeholder="Type here to translate!"
          onChangeText={(text) => this.setState({text})}
        />
        <Button
        onPress= {() => this.onPress(this.state.text)}
        title="Add Item"
        color="blue"
        accessibilityLabel="Learn more about this purple button" />
      <View style={styles.container}>
      <Button
      onPress= {() => {this.forceUpdateHandler}}
      title="Reload"
      color="blue"
      accessibilityLabel="Reload the view" />
        <SwipeableList
        data = {this.state.data}
        renderItem={({item}) => <Text style={styles.item}>{item.key}</Text>}
        />
      </View>
        </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 22
  },
  notContainer: {
    flex: 1,
    backgroundColor: "black"
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44
  }
});

export default HomeScreen;
