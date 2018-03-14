$(function() {
  var code_rule;
  return code_rule = new Vue({
    el: '#customer-detail',
    data: {
      customer_id: 0,
      right_enabled: false,
      left_enabled: false,
      total: 0,
      current_page: 1,
      fans: []
    },
    created: function() {
      return this.init();
    },
    methods: {
      date_format: function(date) {
        if (date) {
          return moment(date).format('YYYY-MM-DD');
        }
      },
      init: function() {
        this.customer_id = $('#customer-detail').attr('info');
        return this.getData();
      },
      leftHandle: function(operation) {
        if ((this.current_page + operation) > 0) {
          this.current_page += operation;
          return this.getData();
        }
      },
      rightHandle: function(operation) {
        if (this.current_page * 3 < this.total) {
          this.current_page += operation;
          return this.getData();
        }
      },
      getData: function() {
        var vm;
        vm = this;
        return $.ajax({
          url: Routes.traffic_list_customers_path(),
          data: {
            id: vm.customer_id,
            current_page: vm.current_page
          },
          dataType: 'json',
          method: 'get'
        }).done(function(resp) {
          vm.total = resp.total;
          if (resp.total > vm.current_page * 3) {
            vm.right_enabled = true;
          } else {
            vm.right_enabled = false;
          }
          if (vm.current_page > 1) {
            vm.left_enabled = true;
          } else {
            vm.left_enabled = false;
          }
          return vm.fans = resp.traffics;
        });
      }
    }
  });
});


