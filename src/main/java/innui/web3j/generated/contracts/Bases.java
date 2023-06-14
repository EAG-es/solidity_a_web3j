package innui.web3j.generated.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.8.
 */
@SuppressWarnings("rawtypes")
public class Bases extends Contract {
    public static final String BINARY = "60806040526001805460ff1916811790553480156200001d57600080fd5b507fa3c796c1157c3cb9fb6f34e43d73431e67f443a38176c32c7dd3b91e150091676040516200007e9060208082526018908201527f6d696e696261736573202d3e20636f6e7374727563746f720000000000000000604082015260600190565b60405180910390a16040805160808101825260606020808301828152600084860152828401929092523383528351808501855260048152631c9bdbdd60e21b918101919091529052905169726f6f745f636c61766560b01b8152600290600a01602060405180830381855afa158015620000fc573d6000803e3d6000fd5b5050506040513d601f19601f82011682018060405250810190620001219190620002a7565b6040828101919091528051600180825281830190925290602080830190803683375050506060820181905280516d7065726d69736f5f6d6178696d6f60901b9190600090620001745762000174620002d7565b60209081029190910181019190915260008054600181018255908052825160049091027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810180546001600160a01b039093166001600160a01b03199093169290921782559183015183927f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56401906200020e90826200037c565b5060408201516002820155606082015180516200023691600384019160209091019062000240565b5050505062000448565b8280548282559060005260206000209081019282156200027e579160200282015b828111156200027e57825182559160200191906001019062000261565b506200028c92915062000290565b5090565b5b808211156200028c576000815560010162000291565b600060208284031215620002ba57600080fd5b5051919050565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b600181811c908216806200030257607f821691505b6020821081036200032357634e487b7160e01b600052602260045260246000fd5b50919050565b601f8211156200037757600081815260208120601f850160051c81016020861015620003525750805b601f850160051c820191505b8181101562000373578281556001016200035e565b5050505b505050565b81516001600160401b03811115620003985762000398620002c1565b620003b081620003a98454620002ed565b8462000329565b602080601f831160018114620003e85760008415620003cf5750858301515b600019600386901b1c1916600185901b17855562000373565b600085815260208120601f198616915b828110156200041957888601518255948401946001909101908401620003f8565b5085821015620004385787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b61226880620004586000396000f3fe608060405234801561001057600080fd5b506004361061012c5760003560e01c8063b2be353c116100ad578063e3dbc94411610071578063e3dbc9441461025d578063e958108314610270578063f5a5713614610290578063f653ea1314610298578063f9d06c4d146102ab57600080fd5b8063b2be353c1461021f578063b776a7a214610227578063c49c3d051461022f578063cdc8793514610237578063d3a41ac51461024a57600080fd5b806379ad29d7116100f457806379ad29d7146101b15780637b318b6e146101c45780638e3ee7ba146101d75780638fecb750146101f9578063a9a4079c1461020c57600080fd5b80630beef324146101315780631d032d01146101465780632dd47cac1461016c5780634dc4643714610174578063688e346714610197575b600080fd5b61014461013f3660046119dd565b6102be565b005b610159610154366004611a76565b6104ad565b6040519081526020015b60405180910390f35b610144610593565b610187610182366004611a76565b6105ce565b6040519015158152602001610163565b6001546101a49060ff1681565b6040516101639190611aae565b6101876101bf366004611ad6565b610636565b6101446101d2366004611b00565b6106f3565b6101ea6101e5366004611b85565b6107e0565b60405161016393929190611bee565b610187610207366004611c22565b6108a8565b61014461021a366004611c70565b61090b565b610144610ae6565b610144610c41565b610144610c77565b610144610245366004611c22565b610caf565b610187610258366004611c22565b610f1b565b61014461026b366004611ce4565b610f62565b61028361027e366004611b85565b6110c8565b6040516101639190611d58565b61015961120b565b6101876102a6366004611d9c565b611279565b6101446102b9366004611a76565b611327565b6102c7336105ce565b6102ec5760405162461bcd60e51b81526004016102e390611de0565b60405180910390fd5b6000805b60005481101561034c576000818154811061030d5761030d611e28565b60009182526020909120600490910201546001600160a01b039081169087160361033a576001915061034c565b610345816001611e54565b90506102f0565b811561036a5760405162461bcd60e51b81526004016102e390611e67565b604080516080810182526000818301526060808201526001600160a01b03881681526020810187905290516002906103a3908790611eba565b602060405180830381855afa1580156103c0573d6000803e3d6000fd5b5050506040513d601f19601f820116820180604052508101906103e39190611ed6565b60408201526000805460018101825590805281517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563600490920291820180546001600160a01b0319166001600160a01b03909216919091178155602083015183927f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56401906104719082611f6f565b50604082015160028201556060820151805161049791600384019160209091019061178a565b5050506104a48785610caf565b50505050505050565b60008060015460ff1660028111156104c7576104c7611a98565b146105145760405162461bcd60e51b815260206004820152601b60248201527f456c20636f6e747261746f206e6f20657374612061637469766f2e000000000060448201526064016102e3565b6000805b600054811015610574576000818154811061053557610535611e28565b60009182526020909120600490910201546001600160a01b03908116908516036105625760019150610574565b61056d816001611e54565b9050610518565b811561058357915061058e9050565b506000199392505050565b919050565b61059c336105ce565b6105b85760405162461bcd60e51b81526004016102e390611de0565b600180546000919060ff191681835b0217905550565b600080805b60005481101561062f57600081815481106105f0576105f0611e28565b60009182526020909120600490910201546001600160a01b039081169085160361061d576001915061062f565b610628816001611e54565b90506105d3565b5092915050565b60008080610643856104ad565b90506000808083126106e6575081905060005b6000828154811061066957610669611e28565b9060005260206000209060040201600301805490508110156106e657856000838154811061069957610699611e28565b906000526020600020906004020160030182815481106106bb576106bb611e28565b9060005260206000200154036106d457600193506106e6565b6106df816001611e54565b9050610656565b5091925050505b92915050565b60405163fc09a9e560e01b81526d7065726d69736f5f6d6178696d6f60901b600482018190529060609073__$b8aea4b0d65a9a3624a5e62f85f41dcce2$__9063fc09a9e590602401600060405180830381865af4158015610759573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052610781919081019061202f565b905061078d3383610636565b8160405160200161079e91906120a6565b604051602081830303815290604052906107cb5760405162461bcd60e51b81526004016102e39190612123565b506107d88686868661140e565b505050505050565b600081815481106107f057600080fd5b6000918252602090912060049091020180546001820180546001600160a01b0390921693509061081f90611eef565b80601f016020809104026020016040519081016040528092919081815260200182805461084b90611eef565b80156108985780601f1061086d57610100808354040283529160200191610898565b820191906000526020600020905b81548152906001019060200180831161087b57829003601f168201915b5050505050908060020154905083565b8051600090600190825b81811015610901576108dd868683815181106108d0576108d0611e28565b6020026020010151610636565b15156000036108ef5760009250610901565b6108fa816001611e54565b90506108b2565b5090949350505050565b610914336105ce565b6109305760405162461bcd60e51b81526004016102e390611de0565b6000805b600054811015610990576000818154811061095157610951611e28565b60009182526020909120600490910201546001600160a01b039081169086160361097e5760019150610990565b610989816001611e54565b9050610934565b81156109ae5760405162461bcd60e51b81526004016102e390611e67565b604080516080810182526000818301526060808201526001600160a01b03871681526020810186905290516002906109e7908690611eba565b602060405180830381855afa158015610a04573d6000803e3d6000fd5b5050506040513d601f19601f82011682018060405250810190610a279190611ed6565b60408201526000805460018101825590805281517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563600490920291820180546001600160a01b0319166001600160a01b03909216919091178155602083015183927f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5640190610ab59082611f6f565b506040820151600282015560608201518051610adb91600384019160209091019061178a565b505050505050505050565b610aef336105ce565b610b0b5760405162461bcd60e51b81526004016102e390611de0565b6000610b16336104ad565b90506000811215610b395760405162461bcd60e51b81526004016102e390611de0565b60008054610b4990600190612136565b81548110610b5957610b59611e28565b906000526020600020906004020160008281548110610b7a57610b7a611e28565b60009182526020909120825460049092020180546001600160a01b0319166001600160a01b03909216919091178155600180820190610bbb90840182612149565b50600282015481600201556003820181600301908054610bdc9291906117d5565b509050506000805480610bf157610bf161221c565b60008281526020812060046000199093019283020180546001600160a01b031916815590610c226001830182611815565b6002820160009055600382016000610c3a9190611852565b5050905550565b610c4a336105ce565b610c665760405162461bcd60e51b81526004016102e390611de0565b60018054819060ff191681806105c7565b610c80336105ce565b610c9c5760405162461bcd60e51b81526004016102e390611de0565b600180546002919060ff191681836105c7565b610cb8336105ce565b610cd45760405162461bcd60e51b81526004016102e390611de0565b6000610cdf836104ad565b90506000811215610d025760405162461bcd60e51b81526004016102e390611de0565b6000805b8351821015610dea576d7065726d69736f5f6d6178696d6f60901b848381518110610d3357610d33611e28565b602002602001015103610dd8576000610d5d336d7065726d69736f5f6d6178696d6f60901b610636565b905080610dd25760405162461bcd60e51b815260206004820152603e60248201527f4e6f20707565646520706f6e6572207065726d69736f5f6d6178696d6f3b207360448201527f6920717569656e206c6f20706964652c206e6f206c6f20706f7365652e20000060648201526084016102e3565b50610dea565b610de3826001611e54565b9150610d06565b610e05856d7065726d69736f5f6d6178696d6f60901b610636565b15610ed257610e25336d7065726d69736f5f6d6178696d6f60901b610636565b15610e3257506001610ed6565b60405162461bcd60e51b815260206004820152606360248201527f536f6c6f20756e2061646d696e6973747261646f7220636f6e207065726d697360448201527f6f5f6d6178696d6f20707565646520646172207065726d69736f73206120756e60648201527f2061646d696e6973747261646f7220636f6e207065726d69736f5f6d6178696d60848201526203797160ed1b60a482015260c4016102e3565b5060015b8015610f14578360008481548110610ef057610ef0611e28565b906000526020600020906004020160030190805190602001906107d892919061178a565b5050505050565b80516000908190815b8181101561090157610f42868683815181106108d0576108d0611e28565b15610f505760019250610901565b610f5b816001611e54565b9050610f24565b610f6b336105ce565b610f875760405162461bcd60e51b81526004016102e390611de0565b336000610f93826104ad565b90506000811215610fb65760405162461bcd60e51b81526004016102e390611de0565b845115610ff0578460008281548110610fd157610fd1611e28565b90600052602060002090600402016001019081610fee9190611f6f565b505b835115611070576002846040516110079190611eba565b602060405180830381855afa158015611024573d6000803e3d6000fd5b5050506040513d601f19601f820116820180604052508101906110479190611ed6565b6000828154811061105a5761105a611e28565b9060005260206000209060040201600201819055505b6001600160a01b03831615610f1457826000828154811061109357611093611e28565b6000918252602090912060049091020180546001600160a01b0319166001600160a01b03929092169190911790555050505050565b606060008212156111275760405162461bcd60e51b815260206004820152602360248201527f4c6120706f736963696f6e206e6f20707565646520736572206e65676174697660448201526203097160ed1b60648201526084016102e3565b6000548080841261118f5760405162461bcd60e51b815260206004820152602c60248201527f4c6120706f736963696f6e20737570657261206c6f7320656c656d656e746f7360448201526b0103232b61030b93930bc97160a51b60648201526084016102e3565b600084815481106111a2576111a2611e28565b90600052602060002090600402016003018054806020026020016040519081016040528092919081815260200182805480156111fd57602002820191906000526020600020905b8154815260200190600101908083116111e9575b505050505092505050919050565b60008060015460ff16600281111561122557611225611a98565b146112725760405162461bcd60e51b815260206004820152601b60248201527f456c20636f6e747261746f206e6f20657374612061637469766f2e000000000060448201526064016102e3565b5060005490565b600080611285846104ad565b905060008112156112a85760405162461bcd60e51b81526004016102e390611de0565b6002836040516112b89190611eba565b602060405180830381855afa1580156112d5573d6000803e3d6000fd5b5050506040513d601f19601f820116820180604052508101906112f89190611ed6565b6000828154811061130b5761130b611e28565b9060005260206000209060040201600201541491505092915050565b60405163fc09a9e560e01b81526d7065726d69736f5f6d6178696d6f60901b600482018190529060609073__$b8aea4b0d65a9a3624a5e62f85f41dcce2$__9063fc09a9e590602401600060405180830381865af415801561138d573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526113b5919081019061202f565b90506113c13383610636565b816040516020016113d291906120a6565b604051602081830303815290604052906113ff5760405162461bcd60e51b81526004016102e39190612123565b50611409836115b6565b505050565b611417336105ce565b6114335760405162461bcd60e51b81526004016102e390611de0565b6000546002106114ab5760405162461bcd60e51b815260206004820152603e60248201527f536f6c6f207365207065726d6974652061637475616c697a617220736920686160448201527f79206d617320646520646f732061646d696e6973747261646f7265732e20000060648201526084016102e3565b60006114b6856104ad565b905060008112156114d95760405162461bcd60e51b81526004016102e390611de0565b8351156115135783600082815481106114f4576114f4611e28565b906000526020600020906004020160010190816115119190611f6f565b505b8251156115935760028360405161152a9190611eba565b602060405180830381855afa158015611547573d6000803e3d6000fd5b5050506040513d601f19601f8201168201806040525081019061156a9190611ed6565b6000828154811061157d5761157d611e28565b9060005260206000209060040201600201819055505b6001600160a01b03821615610f1457816000828154811061109357611093611e28565b6115bf336105ce565b6115db5760405162461bcd60e51b81526004016102e390611de0565b6000546002106116535760405162461bcd60e51b815260206004820152603a60248201527f536f6c6f207365207065726d69746520626f7272617220736920686179206d6160448201527f7320646520646f732061646d696e6973747261646f7265732e2000000000000060648201526084016102e3565b600061165e826104ad565b905060008112156116815760405162461bcd60e51b81526004016102e390611de0565b6000805461169190600190612136565b815481106116a1576116a1611e28565b9060005260206000209060040201600082815481106116c2576116c2611e28565b60009182526020909120825460049092020180546001600160a01b0319166001600160a01b0390921691909117815560018082019061170390840182612149565b506002820154816002015560038201816003019080546117249291906117d5565b5090505060008054806117395761173961221c565b60008281526020812060046000199093019283020180546001600160a01b03191681559061176a6001830182611815565b60028201600090556003820160006117829190611852565b505090555050565b8280548282559060005260206000209081019282156117c5579160200282015b828111156117c55782518255916020019190600101906117aa565b506117d192915061186c565b5090565b8280548282559060005260206000209081019282156117c55760005260206000209182015b828111156117c55782548255916001019190600101906117fa565b50805461182190611eef565b6000825580601f10611831575050565b601f01602090049060005260206000209081019061184f919061186c565b50565b508054600082559060005260206000209081019061184f91905b5b808211156117d1576000815560010161186d565b80356001600160a01b038116811461058e57600080fd5b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff811182821017156118d7576118d7611898565b604052919050565b600067ffffffffffffffff8211156118f9576118f9611898565b50601f01601f191660200190565b600082601f83011261191857600080fd5b813561192b611926826118df565b6118ae565b81815284602083860101111561194057600080fd5b816020850160208301376000918101602001919091529392505050565b600082601f83011261196e57600080fd5b8135602067ffffffffffffffff82111561198a5761198a611898565b8160051b6119998282016118ae565b92835284810182019282810190878511156119b357600080fd5b83870192505b848310156119d2578235825291830191908301906119b9565b979650505050505050565b600080600080608085870312156119f357600080fd5b6119fc85611881565b9350602085013567ffffffffffffffff80821115611a1957600080fd5b611a2588838901611907565b94506040870135915080821115611a3b57600080fd5b611a4788838901611907565b93506060870135915080821115611a5d57600080fd5b50611a6a8782880161195d565b91505092959194509250565b600060208284031215611a8857600080fd5b611a9182611881565b9392505050565b634e487b7160e01b600052602160045260246000fd5b6020810160038310611ad057634e487b7160e01b600052602160045260246000fd5b91905290565b60008060408385031215611ae957600080fd5b611af283611881565b946020939093013593505050565b60008060008060808587031215611b1657600080fd5b611b1f85611881565b9350602085013567ffffffffffffffff80821115611b3c57600080fd5b611b4888838901611907565b94506040870135915080821115611b5e57600080fd5b50611b6b87828801611907565b925050611b7a60608601611881565b905092959194509250565b600060208284031215611b9757600080fd5b5035919050565b60005b83811015611bb9578181015183820152602001611ba1565b50506000910152565b60008151808452611bda816020860160208601611b9e565b601f01601f19169290920160200192915050565b6001600160a01b0384168152606060208201819052600090611c1290830185611bc2565b9050826040830152949350505050565b60008060408385031215611c3557600080fd5b611c3e83611881565b9150602083013567ffffffffffffffff811115611c5a57600080fd5b611c668582860161195d565b9150509250929050565b600080600060608486031215611c8557600080fd5b611c8e84611881565b9250602084013567ffffffffffffffff80821115611cab57600080fd5b611cb787838801611907565b93506040860135915080821115611ccd57600080fd5b50611cda86828701611907565b9150509250925092565b600080600060608486031215611cf957600080fd5b833567ffffffffffffffff80821115611d1157600080fd5b611d1d87838801611907565b94506020860135915080821115611d3357600080fd5b50611d4086828701611907565b925050611d4f60408501611881565b90509250925092565b6020808252825182820181905260009190848201906040850190845b81811015611d9057835183529284019291840191600101611d74565b50909695505050505050565b60008060408385031215611daf57600080fd5b611db883611881565b9150602083013567ffffffffffffffff811115611dd457600080fd5b611c6685828601611907565b60208082526028908201527f4c6120646972656363696f6e206e6f20657320646520756e2061646d696e697360408201526703a3930b237b917160c51b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b808201808211156106ed576106ed611e3e565b60208082526033908201527f45736120646972656363696f6e2064652061646d696e6973747261646f7220796040820152720309032b9ba30903932b3b4b9ba3930b230971606d1b606082015260800190565b60008251611ecc818460208701611b9e565b9190910192915050565b600060208284031215611ee857600080fd5b5051919050565b600181811c90821680611f0357607f821691505b602082108103611f2357634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561140957600081815260208120601f850160051c81016020861015611f505750805b601f850160051c820191505b818110156107d857828155600101611f5c565b815167ffffffffffffffff811115611f8957611f89611898565b611f9d81611f978454611eef565b84611f29565b602080601f831160018114611fd25760008415611fba5750858301515b600019600386901b1c1916600185901b1785556107d8565b600085815260208120601f198616915b8281101561200157888601518255948401946001909101908401611fe2565b508582101561201f5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b60006020828403121561204157600080fd5b815167ffffffffffffffff81111561205857600080fd5b8201601f8101841361206957600080fd5b8051612077611926826118df565b81815285602083850101111561208c57600080fd5b61209d826020830160208601611b9e565b95945050505050565b7f4c6120646972656363696f6e206e6f20657320646520756e2061646d696e697381527f747261646f72206f206e6f207469656e6520656c207065726d69736f20736f6c602082015268034b1b4ba30b2379d160bd1b604082015260008251612116816049850160208701611b9e565b9190910160490192915050565b602081526000611a916020830184611bc2565b818103818111156106ed576106ed611e3e565b818103612154575050565b61215e8254611eef565b67ffffffffffffffff81111561217657612176611898565b61218481611f978454611eef565b6000601f8211600181146121b857600083156121a05750848201545b600019600385901b1c1916600184901b178455610f14565b600085815260209020601f19841690600086815260209020845b838110156121f257828601548255600195860195909101906020016121d2565b508583101561201f5793015460001960f8600387901b161c19169092555050600190811b01905550565b634e487b7160e01b600052603160045260246000fdfea2646970667358221220a3cf1a9abdebdc171ad78397f60eb7801a21d6b27cccff46347a92c7fcc8ce3464736f6c63430008110033";

    public static final String FUNC_ACL_ARRAY = "acl_array";

    public static final String FUNC_ACTIVAR = "activar";

    public static final String FUNC_ACTUALIZAR_ADMINISTRADOR_PERMISOS_ARRAY = "actualizar_administrador_permisos_array";

    public static final String FUNC_actualizar_administrador_usuario_clave_direccion = "actualizar_administrador_usuario_clave_direccion";

    public static final String FUNC_borrar_administrador = "borrar_administrador";

    public static final String FUNC_COMPROBAR_CLAVE = "comprobar_clave";

    public static final String FUNC_crear_administrador = "crear_administrador";

    public static final String FUNC_ESTADO = "estado";

    public static final String FUNC_INACTIVAR = "inactivar";

    public static final String FUNC_LEER_ADMINISTRADOR_PERMISOS_ARRAY = "leer_administrador_permisos_array";

    public static final String FUNC_LEER_ADMINISTRADOR_POS = "leer_administrador_pos";

    public static final String FUNC_LEER_ADMINISTRADORES_NUM = "leer_administradores_num";

    public static final String FUNC_LIMITAR = "limitar";

    public static final String FUNC_SER_ADMINISTRADOR = "ser_administrador";

    public static final String FUNC_SER_ADMINISTRADOR_CON_ALGUN_PERMISO = "ser_administrador_con_algun_permiso";

    public static final String FUNC_SER_ADMINISTRADOR_CON_PERMISO = "ser_administrador_con_permiso";

    public static final String FUNC_SER_ADMINISTRADOR_CON_TODO_PERMISO = "ser_administrador_con_todo_permiso";

    public static final Event AD_AD_U_EVENT = new Event("Ad_ad_u", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event AD_U_U_EVENT = new Event("Ad_u_u", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event MENSAJE_EVENT = new Event("Mensaje", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event OK_EVENT = new Event("Ok", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event ST_U_EVENT = new Event("St_u", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Bases(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bases(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bases(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bases(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<Ad_ad_uEventResponse> getAd_ad_uEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(AD_AD_U_EVENT, transactionReceipt);
        ArrayList<Ad_ad_uEventResponse> responses = new ArrayList<Ad_ad_uEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            Ad_ad_uEventResponse typedResponse = new Ad_ad_uEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.origen = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.destino = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.cantidad = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static Ad_ad_uEventResponse getAd_ad_uEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(AD_AD_U_EVENT, log);
        Ad_ad_uEventResponse typedResponse = new Ad_ad_uEventResponse();
        typedResponse.log = log;
        typedResponse.origen = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.destino = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.cantidad = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<Ad_ad_uEventResponse> ad_ad_uEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAd_ad_uEventFromLog(log));
    }

    public Flowable<Ad_ad_uEventResponse> ad_ad_uEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AD_AD_U_EVENT));
        return ad_ad_uEventFlowable(filter);
    }

    public static List<Ad_u_uEventResponse> getAd_u_uEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(AD_U_U_EVENT, transactionReceipt);
        ArrayList<Ad_u_uEventResponse> responses = new ArrayList<Ad_u_uEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            Ad_u_uEventResponse typedResponse = new Ad_u_uEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.direccion = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.cantidad = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static Ad_u_uEventResponse getAd_u_uEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(AD_U_U_EVENT, log);
        Ad_u_uEventResponse typedResponse = new Ad_u_uEventResponse();
        typedResponse.log = log;
        typedResponse.direccion = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.cantidad = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<Ad_u_uEventResponse> ad_u_uEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAd_u_uEventFromLog(log));
    }

    public Flowable<Ad_u_uEventResponse> ad_u_uEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AD_U_U_EVENT));
        return ad_u_uEventFlowable(filter);
    }

    public static List<MensajeEventResponse> getMensajeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MENSAJE_EVENT, transactionReceipt);
        ArrayList<MensajeEventResponse> responses = new ArrayList<MensajeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MensajeEventResponse typedResponse = new MensajeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MensajeEventResponse getMensajeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MENSAJE_EVENT, log);
        MensajeEventResponse typedResponse = new MensajeEventResponse();
        typedResponse.log = log;
        typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<MensajeEventResponse> mensajeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMensajeEventFromLog(log));
    }

    public Flowable<MensajeEventResponse> mensajeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MENSAJE_EVENT));
        return mensajeEventFlowable(filter);
    }

    public static List<OkEventResponse> getOkEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OK_EVENT, transactionReceipt);
        ArrayList<OkEventResponse> responses = new ArrayList<OkEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OkEventResponse typedResponse = new OkEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.es = (Boolean) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static OkEventResponse getOkEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OK_EVENT, log);
        OkEventResponse typedResponse = new OkEventResponse();
        typedResponse.log = log;
        typedResponse.es = (Boolean) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.mensaje = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<OkEventResponse> okEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOkEventFromLog(log));
    }

    public Flowable<OkEventResponse> okEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OK_EVENT));
        return okEventFlowable(filter);
    }

    public static List<St_uEventResponse> getSt_uEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ST_U_EVENT, transactionReceipt);
        ArrayList<St_uEventResponse> responses = new ArrayList<St_uEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            St_uEventResponse typedResponse = new St_uEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.texto = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cantidad = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static St_uEventResponse getSt_uEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ST_U_EVENT, log);
        St_uEventResponse typedResponse = new St_uEventResponse();
        typedResponse.log = log;
        typedResponse.texto = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.cantidad = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<St_uEventResponse> st_uEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSt_uEventFromLog(log));
    }

    public Flowable<St_uEventResponse> st_uEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ST_U_EVENT));
        return st_uEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple3<String, String, byte[]>> acl_array(BigInteger param0) {
        final Function function = new Function(FUNC_ACL_ARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, byte[]>>(function,
                new Callable<Tuple3<String, String, byte[]>>() {
                    @Override
                    public Tuple3<String, String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, byte[]>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> activar() {
        final Function function = new Function(
                FUNC_ACTIVAR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> actualizar_administrador_permisos_array(String direccion, List<byte[]> permisos_array) {
        final Function function = new Function(
                FUNC_ACTUALIZAR_ADMINISTRADOR_PERMISOS_ARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(permisos_array, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> actualizar_administrador_usuario_clave_direccion(String direccion, String usuario, byte[] clave, String nueva_direccion) {
        final Function function = new Function(
                FUNC_actualizar_administrador_usuario_clave_direccion, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.Utf8String(usuario), 
                new org.web3j.abi.datatypes.DynamicBytes(clave), 
                new org.web3j.abi.datatypes.Address(160, nueva_direccion)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> actualizar_administrador_usuario_clave_direccion(String usuario, byte[] clave, String nueva_direccion) {
        final Function function = new Function(
                FUNC_actualizar_administrador_usuario_clave_direccion, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(usuario), 
                new org.web3j.abi.datatypes.DynamicBytes(clave), 
                new org.web3j.abi.datatypes.Address(160, nueva_direccion)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> borrar_administrador() {
        final Function function = new Function(
                FUNC_borrar_administrador, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> borrar_administrador(String direccion) {
        final Function function = new Function(
                FUNC_borrar_administrador, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> comprobar_clave(String direccion, byte[] clave) {
        final Function function = new Function(FUNC_COMPROBAR_CLAVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.DynamicBytes(clave)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> crear_administrador(String direccion, String usuario, byte[] clave, List<byte[]> permisos_array) {
        final Function function = new Function(
                FUNC_crear_administrador, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.Utf8String(usuario), 
                new org.web3j.abi.datatypes.DynamicBytes(clave), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(permisos_array, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> crear_administrador(String direccion, String usuario, byte[] clave) {
        final Function function = new Function(
                FUNC_crear_administrador, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.Utf8String(usuario), 
                new org.web3j.abi.datatypes.DynamicBytes(clave)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> estado() {
        final Function function = new Function(FUNC_ESTADO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> inactivar() {
        final Function function = new Function(
                FUNC_INACTIVAR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> leer_administrador_permisos_array(BigInteger pos) {
        final Function function = new Function(FUNC_LEER_ADMINISTRADOR_PERMISOS_ARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> leer_administrador_pos(String direccion) {
        final Function function = new Function(FUNC_LEER_ADMINISTRADOR_POS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> leer_administradores_num() {
        final Function function = new Function(FUNC_LEER_ADMINISTRADORES_NUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> limitar() {
        final Function function = new Function(
                FUNC_LIMITAR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> ser_administrador(String direccion) {
        final Function function = new Function(FUNC_SER_ADMINISTRADOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> ser_administrador_con_algun_permiso(String direccion, List<byte[]> permisos_posibles_array) {
        final Function function = new Function(FUNC_SER_ADMINISTRADOR_CON_ALGUN_PERMISO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(permisos_posibles_array, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> ser_administrador_con_permiso(String direccion, byte[] permiso_necesario) {
        final Function function = new Function(FUNC_SER_ADMINISTRADOR_CON_PERMISO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.generated.Bytes32(permiso_necesario)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> ser_administrador_con_todo_permiso(String direccion, List<byte[]> permisos_exigidos_array) {
        final Function function = new Function(FUNC_SER_ADMINISTRADOR_CON_TODO_PERMISO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, direccion), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(permisos_exigidos_array, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Bases load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bases(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bases load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bases(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bases load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bases(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bases load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bases(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bases> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bases.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bases> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bases.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bases> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bases.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bases> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bases.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Ad_ad_uEventResponse extends BaseEventResponse {
        public String origen;

        public String destino;

        public BigInteger cantidad;

        public String mensaje;
    }

    public static class Ad_u_uEventResponse extends BaseEventResponse {
        public String direccion;

        public BigInteger cantidad;

        public BigInteger id;

        public String mensaje;
    }

    public static class MensajeEventResponse extends BaseEventResponse {
        public String mensaje;
    }

    public static class OkEventResponse extends BaseEventResponse {
        public Boolean es;

        public String mensaje;
    }

    public static class St_uEventResponse extends BaseEventResponse {
        public String texto;

        public BigInteger cantidad;
    }
}
