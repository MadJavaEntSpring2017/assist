(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('team', {
            controller: TeamController,
            controllerAs: 'vm',
            templateUrl: 'components/team/team.html',
            bindings: {
                team: '<'
            },
            require: {}
        });

    TeamController.$inject = ['teamService', 'messageService'];

    function TeamController(teamService, messageService) {
        var vm = this;

        vm.save = save;

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.team && vm.team.id) {
                savePromise = teamService.updateTeam(vm.team.id, writeRequest);
            } else {
                savePromise = teamService.createTeam(writeRequest);
            }

            savePromise
                .then(function () {
                    messageService.showSuccessMessage();
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function createWriteRequest() {
            return {
                name: vm.team.name,
                active: vm.team.active
            };
        }
    }
})();