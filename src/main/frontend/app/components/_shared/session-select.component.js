(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('sessionSelect', {
            controller: SessionSelectController,
            controllerAs: 'vm',
            templateUrl: 'components/_shared/session-select.html',
            bindings: {
                session: '<',
                onSelect: '&',
                required: '@'
            },
            require: {
                form: '^form'
            }
        });

    SessionSelectController.$inject = ['$q', 'sessionService'];

    function SessionSelectController($q, sessionService) {
        var vm = this;

        vm.selectSession = selectSession;

        function selectSession() {
            vm.onSelect({
                $event: {
                    session: vm.session
                }
            });
        }

        vm.$onInit = function () {
            $q.all({
                sessions: sessionService.getAllSessions()
            }).then(function (results) {
                vm.sessions = results.sessions;
            });
        };

        vm.$onChanges = function (changes) {
            if (changes.session) {
                vm.session = angular.copy(vm.session);
            }
        };
    }
})();