(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('roster', {
            controller: RosterController,
            controllerAs: 'vm',
            templateUrl: 'components/roster/roster.html',
            bindings: {
                roster: '<',
                commits: '<'
            },
            require: {}
        });

    RosterController.$inject = ['$q', 'teamService', 'sessionService', 'rosterService', 'messageService', '$state'];

    function RosterController($q, teamService, sessionService, rosterService, messageService, $state) {
        var vm = this;

        vm.save = save;
        vm.selectTeam = selectTeam;
        vm.selectSession = selectSession;

        function selectSession(event) {
            vm.session = event.session;
        }

        function selectTeam(event) {
            vm.team = event.team;
        }

        vm.$onInit = function () {
            vm.roster = vm.roster ? vm.roster : {};
            vm.commits = vm.commits ? vm.commits : {};
            $q.all({
                team: vm.roster.teamId ? teamService.getTeam(vm.roster.teamId) : {},
                session: vm.roster.sessionId ? sessionService.getSessionDetails(vm.roster.sessionId) : {}
            }).then(function (results) {
                vm.team = results.team;
                vm.session = results.session;
            });
        };

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.roster && vm.roster.id) {
                savePromise = rosterService.updateRoster(vm.roster.id, writeRequest);
            } else {
                savePromise = rosterService.createRoster(writeRequest);
            }

            savePromise
                .then(function (results) {
                    messageService.showSuccessMessage();
                    $state.go('main.roster-details', { rosterId: results.id });
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function createWriteRequest() {
            return {
                sessionId: vm.session.id,
                teamId: vm.team.id
            };
        }
    }
})();