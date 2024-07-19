EXTRA_OEMAKE_append_axon-am62xx = " CFG_WITH_SOFTWARE_PRNG=y CFG_TEE_CORE_LOG_LEVEL=1"
EXTRA_OEMAKE_append_axon-am62ax = " CFG_TEE_CORE_LOG_LEVEL=1"

do_compile_append_axon-am62xx() {
    optee_sign_k3hs
}

do_compile_append_axon-am62ax() {
    optee_sign_k3hs
}
