<template>
    <div class="row">
        <div class="col">
            <h3>Welcome, </h3>
            <div class="alert alert-info">
                {{userInfo}}
            </div>
            <router-link to="/logout">
                Logout
            </router-link>
        </div>
    </div>
</template>

<script>
import UserInfoStore from '../app/user-info-store';
export default {
    name: 'Home',
    data: function() {
        return{
            userPoolId: process.env.VUE_APP_COGNITO_USERPOOL_ID,
            userInfo: UserInfoStore.state.cognitoInfo
        }
    }
}
</script>

<style>

</style>
