(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('playerList', {
            controller: PlayerListController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player-list.html',
            require: {},
            bindings: {}
        });

    PlayerListController.$inject = ['$log', '$q', 'playerService'];

    function PlayerListController($log, $q, playerService) {
        var vm = this;
        vm.title = 'Player List';

        vm.$onInit = activate();

        function activate() {
            $q.all({
                players: playerService.getAllPlayers()
            }).then(
                function (results) {
                    vm.players = results.players;
                }
            );
        }





        // getAllPlayers();
        //
        // function getAllPlayers() {
        //     playerService.getAllPlayers()
        //         .then(function (results) {
        //             $log.debug(results);
        //         });
        // }
    }
})();