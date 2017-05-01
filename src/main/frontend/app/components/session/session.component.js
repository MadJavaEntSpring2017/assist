(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('session', {
            controller: SessionController,
            controllerAs: 'vm',
            templateUrl: 'components/session/session.html',
            bindings: {
                session: '<'
            },
            require: {}
        });

    SessionController.$inject = ['sessionService', 'messageService', '$state'];

    function SessionController(sessionService, messageService, $state) {
        var vm = this;

        vm.save = save;
        vm.selectSplit = selectSplit;

        vm.$onInit = function () {
            vm.session = vm.session ? vm.session : {};
        };

        function selectSplit(event) {
            vm.session.split = event.split;
        }

        function save() {
            console.log('saving session'); // todo delete
        }

        function createWriteRequest() {
            return {};
        }
    }
})();