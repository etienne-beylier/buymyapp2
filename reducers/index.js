import { combineReducers } from "redux";
import keys from "./keys_reducer";
import selectedValues from "./selections_reducer";
import modal from "./modal_reducer";
import auth from './auth';

export default combineReducers({
  keys,
  selectedValues,
  modal,
  auth
});
