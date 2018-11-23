package net.oneandone.maven.poms.sampleprojectspringboot

import spock.lang.Specification
import spock.lang.Subject

class SpockTest extends Specification {
    def 'My find test'() {
        given:
        @Subject sut = 'hello'
        expect:
        sut == 'hello'
    }
}