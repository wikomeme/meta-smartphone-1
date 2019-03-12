FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH_mako = "${MACHINE_ARCH}"
PACKAGE_ARCH_hammerhead = "${MACHINE_ARCH}"

SRC_URI_append_mako = " file://70-mako.rules"
SRC_URI_append_hammerhead = " file://70-hammerhead.rules \
                              file://70-qmi-modem.rules \
                              file://70-qmi-ofono.rules \
                              file://70-qmi-qcom_rmtfs.rules \
"

do_install_append_mako() {
    install -m 0644 ${WORKDIR}/70-mako.rules ${D}${sysconfdir}/udev/rules.d/70-mako.rules
}

do_install_append_hammerhead() {
    install -m 0644 ${WORKDIR}/70-hammerhead.rules ${D}${sysconfdir}/udev/rules.d/70-hammerhead.rules
    install -m 0644 ${WORKDIR}/70-qmi-modem.rules ${D}${sysconfdir}/udev/rules.d/70-qmi-modem.rules
    install -m 0644 ${WORKDIR}/70-qmi-ofono.rules ${D}${sysconfdir}/udev/rules.d/70-qmi-ofono.rules
    install -m 0644 ${WORKDIR}/70-qmi-qcom_rmtfs.rules ${D}${sysconfdir}/udev/rules.d/70-qmi-qcom_rmtfs.rules
}
