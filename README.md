# solidity_a_web3j
Proyecto Netbeans con maven para generar archivos java wrappers (envolventes) de archivos Solidiy

Depende de:
- Modelos: https://github.com/EAG-es/modelos

Utiliza el plugin Web3j:
```
            <plugin>
                <groupId>org.web3j</groupId>
                <artifactId>web3j-maven-plugin</artifactId>
                <version>4.9.4</version>
                <configuration>
                    <packageName>innui.web3j.generated.contracts</packageName>
                    <sourceDestination>src/main/java</sourceDestination>
                    <nativeJavaType>true</nativeJavaType>
                    <outputFormat>java,abi</outputFormat>
                    <soliditySourceFiles>
                        <directory>src/main/solidity</directory>
                        <includes>
                            <include>**/*.sol</include>
                        </includes>
                    </soliditySourceFiles>
                    <outputDirectory>
                        <java>src/main/java</java>
                        <bin>src/main/bin</bin>
                        <abi>src/main/abi</abi>
                    </outputDirectory>
                    <contract>
                        <includes>
                            <include>greeter</include>
                        </includes>
                        <excludes>
                            <exclude>mortal</exclude>
                        </excludes>
                    </contract>
                    <pathPrefixes>
                        <pathPrefix>dep=../dependencies</pathPrefix>
                    </pathPrefixes>
                </configuration>
                <dependencies>
                        <dependency>
                                <groupId>org.web3j</groupId>
                                <artifactId>web3j-sokt</artifactId>
                                <version>0.2.3</version>
                        </dependency>
                </dependencies>
            </plugin> 
```
