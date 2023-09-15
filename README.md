# PELauncher: a Minecraft Launcher

A pretty much work in progress Minecraft launcher aiming to be simple and lightweight. It is
currently able to boot Minecraft 1.20.1 on systems with Java 17.

DON'T EXPECT ANYTHING FROM THIS PROJECT YET. IT'S NOT EVEN IN ALPHA.

Feature goals:

- To don't expect anything from the user: The appropriate JVM for each Minecraft version is
  downloaded on the fly, even if the player doesn't have Java installed.
- To manage multiple Minecraft instances. A similar approach to the [MultiMC](https://multimc.org/)
  launcher.
- To support premium and no premium accounts with Microsoft authentication.
- To distribute binaries for Windows, Linux and macOS with a nice CI pipeline.

Schemas in `pelauncher/schemas/` where generated using
[jsonschem2pojo](https://www.jsonschema2pojo.org/) with the Minecraft HTTP API responses.

## References

- Reverse engineered Minecraft API Documentation: <https://wiki.vg/Main_Page>
- Game Files (assets downloading): <https://wiki.vg/Game_files>
- Launching the `client.jar`: <https://wiki.vg/Launching_the_game>
- Version manifest: <https://minecraft.fandom.com/wiki/Version_manifest.json>
- `.minecraft` directory <https://minecraft.fandom.com/wiki/.minecraft>
- New and changelogs: <https://github.com/PrismLauncher/PrismLauncher/issues/194>
- JSON version example: <https://piston-meta.mojang.com/v1/packages/cdad018fbbe4e10919b560da3d1640d7b6355dbf/1.20.1.json>
