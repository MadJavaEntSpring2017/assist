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

    SessionController.$inject = ['$q', 'seasonService', 'sessionService', 'messageService', '$state', '$stateParams'];

    function SessionController($q, seasonService, sessionService, messageService, $state, $stateParams) {
        var vm = this;

        vm.save = save;
        vm.selectSplit = selectSplit;
        vm.selectSeason = selectSeason;

        vm.$onInit = function () {
            vm.session = vm.session ? vm.session : {};
            vm.split = vm.session.split ? vm.session.split : {};
            vm.rosters = vm.rosters ? vm.rosters : {};
            vm.seasonId = $stateParams.seasonId ? $stateParams.seasonId : vm.session.season.id;
            $q.all({
                season: vm.seasonId ? seasonService.getSeasonDetails(vm.seasonId) : {}
            }).then(function (results) {
                vm.season = results.season;
            })
        };

        function selectSeason(event) {
            vm.season = event.season;
        }

        function selectSplit(event) {
            vm.split = event.split;
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
                seasonId: vm.season.id,
                splitId: vm.split.id
            };
        }
    }
})();