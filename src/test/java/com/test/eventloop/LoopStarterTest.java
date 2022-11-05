package com.test.eventloop;

import com.test.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LoopStarterTest {

    @BeforeEach
    public void setup() {
    }

    @Test
    void loop_starter_successful() {
        StartCommand startCommand = new StartCommand();
        HardStopCommand hardStopCommand = new HardStopCommand();

        Worker worker = new Worker();
        worker.add(startCommand);
        worker.add(hardStopCommand);
        worker.start();
    }
}