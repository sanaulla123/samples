var state = {
  cognitoInfo: {},
  loggedIn: false,
  loadingState: true,
  errorLoadingState: false
}

function setLoggedIn(newValue) {
  state.loggedIn = newValue;
}

function setLoggedOut() {
  state.loggedIn = false;
  state.cognitoInfo = {};
}

function setCognitoInfo(newValue){
  state.cognitoInfo = newValue;
}

export default {
  state: state,
  setLoggedIn: setLoggedIn,
  setLoggedOut: setLoggedOut,
  setCognitoInfo: setCognitoInfo
}