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

    PlayerController.$inject = ['playerService', 'messageService'];

    function PlayerController(playerService, messageService) {
        var vm = this;

        vm.save = save;

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.player && vm.player.id) {
                savePromise = playerService.updatePlayer(vm.player.id, writeRequest);
            } else {
                savePromise = playerService.createPlayer(writeRequest);
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
                firstname: vm.player.firstname,
                lastname: vm.player.lastname,
                email: vm.player.email,
                birthday: vm.player.birthday,
                active: vm.player.active
            };
        }
    }
})();