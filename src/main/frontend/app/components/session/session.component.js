(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('session', {
            controller: SessionController,
            controllerAs: 'vm',
            templateUrl: 'components/session/session.html',
            bindings: {
                session: '<',
                rosters: '<'
            },
            require: {}
        });

    SessionController.$inject = ['sessionService', 'messageService', '$state'];

    function SessionController(sessionService, messageService, $state) {
        var vm = this;

        vm.save = save;
        vm.selectSplit = selectSplit;
        vm.selectSeason = selectSeason;

        vm.$onInit = function () {
            vm.session = vm.session ? vm.session : {};
            vm.rosters = vm.rosters ? vm.rosters : {};
        };

        function selectSeason(event) {
            vm.session.season = event.season;
        }

        function selectSplit(event) {
            vm.session.split = event.split;
        }

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.session && vm.session.id) {
                savePromise = sessionService.updateSession(vm.session.id, writeRequest);
            } else {
                savePromise = sessionService.createSession(writeRequest);
            }

            savePromise
                .then(function (results) {
                    messageService.showSuccessMessage();
                    $state.go('main.session-details', { sessionId: results.id });
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function createWriteRequest() {
            return {
                year: vm.session.year,
                seasonId: vm.session.season.id,
                splitId: vm.session.split.id
            };
        }
    }
})();