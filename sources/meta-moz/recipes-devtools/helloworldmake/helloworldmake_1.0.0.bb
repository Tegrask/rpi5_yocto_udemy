SUMMARY = " Recipe for Software package that uses GNU Make"
LICENSE = "CLOSED"
SRC_URI = "git://github.com/mozcelikors/makefile-example.git;protocol=https;branch=master"
SRCREV = "cce3e754d35514b82e9ca27d0fe1cb31eaa22b51"

RDEPENDS:${PN}:append = " bash "
DEPENDS:append = " "

S = "${WORKDIR}/git"

do_compile(){
    export OECORE_TARGET_SYSROOT=${STAGING_DIR_TARGET}
    export LDFLAGS="${LDFLAGS} -Wl,--hash-style=gnu"
    make LDFLAGS="${LDFLAGS}"
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 ${S}/app ${D}${bindir}/app
    install -m 0755 ${S}/app ${D}${bindir}/app2

}
PACKAGE = "${PN} \
           ${PN}-app \
           ${PN}-app2 \
           ${PN}-dbg \
"

FILES:${PN}:append = " ${bindir}/app "
FILES:${PN}-app:append = " ${bindir}/app "
FILES:${PN}-app2:append = " ${bindir}/app2 "
FILES:${PN}-dbg:append = " ${bindir}/.debug/app ${bindir}/.debug/app2 "
