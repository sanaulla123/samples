var paginationTemplate = '\
    <nav aria-label="Page navigation example">\
        <ul class="pagination">\
        <li class="page-item" :class="{disabled: disablePrev}">\
            <a class="page-link" href="javascript:void(0);"\
                v-on:click="previous">Previous</a>\
        </li>\
        <li class="page-item" :class="{ active: (p == current)}" v-for="p in range">\
            <a class="page-link" href="javascript:void(0);" \
                v-on:click="callback(p)">{{ p }}</a>\
        </li>\
        <li class="page-item" :class="{disabled: disableNext}">\
            <a class="page-link" v-on:click="next" href="javascript:void(0)">Next</a>\
        </li>\
        </ul>\
    </nav>\
';

Vue.component('pagination', {
    template: paginationTemplate,
    props: ["total", "current", "callback", "maxVisible"],
    data: function(){
        return {
            start: 1,
            end: (this.maxVisible >= this.total? this.total : this.maxVisible)
        }
    },
    watch:{
        total: function(){
            this.end = (this.maxVisible >= this.total? this.total : this.maxVisible);
        }
    },
    computed: {
        range: function(){
            return _.range(this.start, this.end + 1, 1);
        },
        disablePrev: function(){
            return this.start <= 1;
        },
        disableNext: function(){
            return this.end >= this.total;
        }
    },
    methods:{
        next: function(){
            var newEnd = this.end + this.maxVisible;
            if ( newEnd <= this.total){
                this.start = this.start + this.maxVisible;
                this.end = newEnd;  
            }
            
        },
        
        previous: function(){
            var newStart = this.start - this.maxVisible;
            if ( newStart >= 1){
                this.start = newStart;
                this.end = this.end - this.maxVisible;  
            }
        }
        
    }
    
});