FILESEXTRAPATHS:prepend := "${THISDIR}/files2:"
SUMMARY = "recipe file for a few raspberrypi tools"
LICENSE = "CLOSED"
SRC_URI = "git://github.com/raspberrypi/utils.git;protocol=https;branch=master"
SRC_URI += "file://git/CMakeLists.txt"
SRCREV = "92900c5c733c8b91a67b1772d4f0a25104f2b05d"

RDEPENDS:${PN}:append = " bash "

S = "${WORKDIR}/git"

inherit cmake pkgconfig

do_install(){
    install -d ${D}${bindir}
    install -m 0755 ${B}/pinctrl/pinctrl ${D}${bindir}
    install -m 0755 ${S}/raspinfo/raspinfo ${D}${bindir}

}

FILES:{PN} += " /usr/share/bash-completion/completions/pinctrl"
FILES:{PN} += " ${bindir}/pinctrl"
FILES:{PN} += " ${bindnir}/raspinfo"