const defaultState = {
  isLoggedIn: 0,
  username: "",
  password: "",
};

export default function reducer(state = defaultState, action) {
  switch (action.type) {
    case "LOGIN":
      return Object.assign({}, state, {
        isLoggedIn: "LOGIN",
        username: action.username,
        password: action.password
      });
      case "SIGNUP":
      console.log("cdcdcd");
      return Object.assign({}, state, {
        isLoggedIn: "SIGNUP",
        username: action.username,
        password: action.password
      });
    case "LOGOUT":
      return Object.assign({}, state, {
        isLoggedIn: "LOGOUT",
        username: "",
        password: ""
      });
    default:
      return state;
  }
}
