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

    PlayerController.$inject = ['playerService'];

    function PlayerController(playerService) {
        var vm = this;

        vm.save = save;

        function save() {
            var writeRequest = createWriteRequest();

            if (vm.player && vm.player.id) {
                playerService.updatePlayer(vm.player.id, writeRequest);
            } else {
                playerService.createPlayer(writeRequest);
            }
        }

        function createWriteRequest() {
            return {
                firstname: vm.player.firstname,
                lastname: vm.player.lastname,
                email: vm.player.email,
                birthday: vm.player.birthday,
                active: vm.player.active
            };
        }
    }
})();