(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('player', {
            controller: PlayerController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player.html',
            bindings: {
                player: '<'
            },
            require: {}
        });

    PlayerController.$inject = ['playerService', 'messageService', '$state'];

    function PlayerController(playerService, messageService, $state) {
        var vm = this;

        vm.save = save;
        vm.selectTeam = selectTeam;

        vm.$onInit = function () {
            vm.player = vm.player ? vm.player : {};
            vm.player.active = vm.player.active ? vm.player.active : false;
        };

        function selectTeam(event) {
            vm.player.team = event.team;
        }
        
        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.player && vm.player.id) {
                savePromise = playerService.updatePlayer(vm.player.id, writeRequest);
            } else {
                savePromise = playerService.createPlayer(writeRequest);
            }

            savePromise
                .then(function (results) {
                    messageService.showSuccessMessage();
                    $state.go('main.player-details', { playerId: results.id });
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function createWriteRequest() {
            return {
                firstname: vm.player.firstname,
                lastname: vm.player.lastname,
                email: vm.player.email,
                birthday: vm.player.birthday,
                active: vm.player.active,
                teamId: vm.player.team ? vm.player.team.id : null
            };
        }
    }
})();