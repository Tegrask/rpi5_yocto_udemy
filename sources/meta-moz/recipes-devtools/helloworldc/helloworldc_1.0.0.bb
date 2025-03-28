SUMMARY = "${PN} file recipe"
LICENSE = "CLOSED"

SRC_URI = "file://mysource/helloyp.c"

S = "${WORKDIR}/mysource"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
     ${CC}  ${S}/helloyp.c -o ${B}/helloyp
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/helloyp ${D}${bindir}/helloyp
}