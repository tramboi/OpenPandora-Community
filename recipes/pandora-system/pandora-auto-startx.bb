DESCRIPTION = "Autostart X on the first boot to support the first run wizard on the OpenPandora."
LICENSE = "GPLV2"

RDEPENDS_${PN} = "xinit"

# Based on the scripts by JohnX/Mer Project - http://wiki.maemo.org/Mer/

COMPATIBLE_MACHINE = "omap3-pandora"

PR = "r1"

SRC_URI = " \
          file://rc.auto-startx \
"

inherit update-rc.d

INITSCRIPT_NAME = "auto-startx-init"
INITSCRIPT_PARAMS = "start 60 2 3 4 . stop 60 0 1 5 6 ."

do_install() {         
          install -d ${D}${sysconfdir}/init.d/
          cp -pP ${WORKDIR}/rc.auto-startx ${D}${sysconfdir}/init.d/auto-startx-init
}

FILES_${PN} += "${sysconfdir}/init.d/auto-startx-init"
