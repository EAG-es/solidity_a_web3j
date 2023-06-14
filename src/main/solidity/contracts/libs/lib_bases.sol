// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.8.17;

library textos_bases {

    function ser_igual_bytes(bytes memory bytex_1, bytes memory bytex_2) public pure 
    returns(bool) {
        return (bytex_1.length == bytex_2.length) && (keccak256(bytex_1) == keccak256(bytex_2));
    }

    function ser_igual_string(string memory tex_1, string memory tex_2) public pure 
    returns(bool) {
        return ser_igual_bytes(bytes(tex_1), bytes(tex_2));
    }

    function convertir_bytes32_a_string(bytes32 bytex32) public pure 
    returns (string memory) {
        uint i = 0;
        while (true) {
            if (i >= 32 || bytex32[i] == 0) {
                break;
            }
            i = i + 1;
        }
        if (i == 0) {
            return "";
        } else {
            bytes memory bytes_array = new bytes(i);
            for (i = 0; i < 32 && bytex32[i] != 0; i++) {
                bytes_array[i] = bytex32[i];
            }
            return string(bytes_array);
        }
    }

}