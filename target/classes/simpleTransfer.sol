// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

//import "./2_publickey.sol";

contract SimpleTransfer {
    address public owner;
    mapping(address => uint256) public balances;



    constructor() public {
        owner = msg.sender;
    }

    function deposit(address payable _to, uint _amount) public {
        require(_amount > 0, "Deposit amount must be greater than 0.");
        balances[_to] += _amount;
    }


    function transfer(address _sender, address payable _to, uint256 _amount) public {
        require(balances[_sender] >= _amount, "Insufficient funds.");
        require(_amount > 0, "Transfer amount must be greater than 0.");
        //PublicKey publicKey = PublicKey(publicKeyContract);
        //require(publicKey.verifySignature(_message, _signature), "Invalid signature.");
        balances[_sender] -= _amount;
        balances[_to] += _amount;
    }


    function balance(address _account) external view returns (uint) {
        return balances[_account];
    } 
}
