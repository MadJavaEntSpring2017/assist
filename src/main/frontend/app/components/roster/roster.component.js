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

    RosterController.$inject = ['$q', 'teamService', 'sessionService', 'rosterService', 'messageService', '$state',
                                '$stateParams'];

    function RosterController($q, teamService, sessionService, rosterService, messageService, $state,
                              $stateParams) {
        var vm = this;

        vm.save = save;
        vm.selectTeam = selectTeam;
        vm.selectSession = selectSession;
        vm.updateCommits = updateCommits;

        function updateCommits(event) {
            vm.roster.commits = event.commits;
            vm.commits = vm.roster.commits;
        }

        function selectSession(event) {
            vm.session = event.session;
        }

        function selectTeam(event) {
            vm.team = event.team;
        }

        vm.$onInit = function () {
            vm.roster = vm.roster ? vm.roster : {};
            vm.commits = vm.commits ? vm.commits : {};
            vm.teamId = $stateParams.teamId ? $stateParams.teamId : vm.roster.teamId;
            vm.sessionId = $stateParams.sessionId ? $stateParams.sessionId : vm.roster.sessionId;
            $q.all({
                team: vm.teamId ? teamService.getTeam(vm.teamId) : {},
                session: vm.sessionId ? sessionService.getSessionDetails(vm.sessionId) : {}
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