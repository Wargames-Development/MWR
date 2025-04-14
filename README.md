<!-- Update with new links and icons to wargames parts -->
<!-- [![Curse Forge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg)]() -->
<!--[![Modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)]() -->

[![Patreon](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/donate/patreon-plural_vector.svg)](https://www.patreon.com/c/WargamesMc)
[![Discord](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://discord.gg/t9fd6uGM)

# Wargames: Modern Warfare Reworked

<!-- Write a quick introduction of the mod this is and show the banner of that mod / representation overview of features -->
Wargames: Modern Warfare Reworked (MWR) is a modernized port and evolution of the original Modern Warfare Cubed (MWC) mod. Built for the Minecraft 1.7.10 Forge environment, MWR aims to reintroduce and refine the original gameplay features with a focus on modular armor systems, immersive tactical gear, and eventually modern firearms and advanced combat mechanics. This reboot is developed under the Wargames Development Group for the larger Wargames server ecosystem.

## Features

<!-- Write about the features of the mod and include some gifs or images to help document major features. Below is an example of image/gif addition -->
<!-- ![Weapon Showcase](https://raw.githubusercontent.com/Cubed-Development/Modern-Warfare-Cubed/main/assets/showcase/Weapon%20Showcase.gif) -->

This early development version of MWR will begin by porting and reworking key wearable gear from Modern Warfare Cubed:

✅ Initial Focus

* Armor Sets

    * Tiered tactical uniforms with varying levels of protection

* Vests

    * Functional modular vests with future support for pouches and attachments

* Backpacks

    * Visual and potentially functional backpacks, may provide future inventory expansions

    *These assets will focus on parity with MWC while introducing room for new mechanics later.*

⚠️ Future Features (Subject to Feasibility)

Porting of the following features from MWC may happen later, if technically plausible within the 1.7.10 environment:

* Firearms & attachments system

* Ammunition types and reload mechanics

* Throwable equipment (grenades, flashbangs, etc.)

* Inventory systems like the loadout builder

* Cosmetic and animation enhancements

## Showcase

**SHOWCASE IMAGES COMING SOON!**

<!-- 
## Documentation

If there is some documentation then please include this and update the link! The website forum documentation page needs to be produced first...

We now have documentation, it is still early, so not everything might be there, you can check it out [here](https://docs.wargames.uk/<mod>)!
-->

---

## Support Us!

<!-- Update this once wargames hosting comes out properly to direct to purchase a server! -->

Are you enjoying our mod?
Consider supporting our development!

Instead of asking for donations the **Wargames Development Group** have produced a project called host.wargames.uk, Please consider keeping an eye out for when we release support through server hosting!

But for now until that is released, all monetary contributions made via Patreon are being put right back into the development of the mod.

[![Patreon](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/donate/patreon-plural_vector.svg)](https://patreon.com/ModernWarfareCubed)

## Need to get in touch?

<!-- If Discord server or contact lines via email change, update this section here. -->

Our primary way of communicating with the community is through our [Discord Server](https://discord.gg/t9fd6uGM).
Join our great community today!

Feel free to send an email to dev@wargames.uk if you have any concerns about the development, or if you find dangerous issues or abuse, contact abuse@wargames.uk
Please note that this inbox will not reply to any queries or help about the mod itself, please use the discord server for that instead.

---

## Compiling a current Version

If you are annoyed by our slow releases (since we work on the server's schedule), and you can see we have done work,
feel free to compile it yourself, however it might not work due to incomplete fixes or updates!

<!-- This is a very basic guide to getting the repo setup, this is on purpose, but could be updated if things change or is wanted -->

<details>
<summary>View Detailed Steps:</summary>

1. Enter the source code directory
   1. Navigate to the location where you downloaded the sources. *it should be `C:/Users/%USER%/Downloads`*

   2. Enter the downloaded source tree.

   3. For Win11 Shift Right-Click, and select `Open in terminal` This will open a CMD instance in this location, *if this for some reason is a powershell instance please follow below:*
        1. Open a CMD window (search CMD)

        2. cd to the directory:

        ```cmd
            cd /path/to/project-root/dir/
        ```

<br>

2. Build the mod
    1. Type `gradlew build` and then click enter

    2. Wait for completion

<br>

3. Locate the mod file.
   1. Navigate to the location where you downloaded the sources. *it should be `C:/Users/%USER%/Downloads`*

   2. Enter the downloaded source tree.

   3. Navigate to `build/libs`.

   4. Grab the .jar file from there. *This mod might be unstable due to the state of current development*

</details>

## Contributing

<!-- This is a very basic guide to getting the repo setup, this is on purpose, but could be updated if things change or is wanted -->

Anyone and everyone is welcome to contribute and help out with the project!
However, We hope you have some understanding of modding and therefore are giving basic instructions below

<details>
<summary>View Detailed Steps:</summary>

1. Follow the Step 1 from compiling the latest version above,

2. Setup the workspace
    1. Type `gradlew setupDecompWorkspace` and then click enter

    2. Wait for completion

3. Depending on your editor of choice follow one of the below:

* Intellij Idea:
    1. Generate idea files by running `gradlew idea` in the cmd.

    2. Open the .ipr file in the explorer to intellij Idea.

* Eclipse Users:
    1. Generate eclipse files by running  `gradlew eclipse` in the cmd.

    2. Select the **eclipse** folder as a workspace when opening eclipse.

</details>

### Want to join the Development Team?

We are always looking for people to assist us in our development, as our time is more pushed into the infostructure, hardware and minecraft server.
Therefore if you wish to help out in a more official way then please get in contact with us through our Discord Server. (only if you've previously worked on any other projects)

[![Discord](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://discord.gg/t9fd6uGM)

## Meet our Team & Credits

<!-- Add Credit to the developers of any used code, models or textures, including links. -->

### Credits to Modern Warfare Cubed (MWC)

This mod owes a great deal to the incredible work done by the original developers of [Modern Warfare Cubed (MWC)](https://github.com/Cubed-Development/Modern-Warfare-Cubed).
We want to explicitly thank the MWC team and furthermore the VMW team and Vic4Games himself for their additions to the Minecraft 1.7.10 & 1.12.2 Modding Scene!

Parts of the following have been referenced or will be adapted from MWC during the development of this project:

* Armor models and textures

* Tactical vests and backpacks

* General structure and design inspiration

* Certain utility functions and codebase layout where appropriate

If you are a former developer of MWC and feel you deserve specific credit for something in this project, please don’t hesitate to reach out through our [Discord](https://discord.gg/t9fd6uGM) or email: dev@wargames.uk

⚠️ All reused content is done with credit and attribution where due. If any issues arise, we are happy to amend and provide further credit or remove material if necessary.

### Wargames Development Group Team

Another massive thank you to all the contributors and members of the development team.
We wouldn't be where we are now without the support from you all!

<!-- Update with Vikings correct link to github account -->

- [Glac](https://github.com/RhysHopkins04) - Developer
- [Barrack](https://github.com/BateNacon) - Developer
- [Ocean](https://github.com/Oceanseaj) - Designer
- [Viking](https://github.com/Wargames-Development) - Advisor

<!--
### Our Contributors

Update with the links to the correct repo's

[![Contributors](https://contrib.rocks/image?repo=Wargames-Development/<reponame>)](https://github.com/Wargames-Development/<reponame>/graphs/contributors)

-->

---