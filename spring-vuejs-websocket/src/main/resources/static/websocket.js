var stompClient = null;
$(function(){
    new Vue({
        el: "#websocket",
        data: {
            messages: []
        },
        methods: {
            connect: function(){
                var socket = new SockJS('/connect');
                stompClient = Stomp.over(socket);
                var that = this;
                stompClient.connect({}, function(frame) {

                    that.handleMessageReceipt("Connected");
                    stompClient.subscribe('/topic/messages',
                        function(messageOutput) {
                        that.handleMessageReceipt(messageOutput.body);
                    });
                });
            },
            disconnect: function(){
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                this.handleMessageReceipt("Disconnected");
            },
            startTask: function(){
                if ( stompClient != null ){
                    stompClient.send("/ws/start");
                }else{
                    alert("Please connect first");
                }
            },
            stopTask: function(){
                if ( stompClient != null ){
                    stompClient.send("/ws/stop");
                }else{
                    alert("Please connect first");
                }
            },
            handleMessageReceipt: function (messageOutput) {
                this.messages.push(messageOutput);
            }
        }
    });
});