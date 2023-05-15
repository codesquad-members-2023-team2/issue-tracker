import type { Meta, StoryObj } from '@storybook/react';
import Button from '../Button';
import React from 'react';

const meta = {
  title: 'Common/Button',
  component: Button,
} satisfies Meta<typeof Button>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Primary: Story = {
  args: {
    isFlexible: false,
    type: 'Contained',
    hasIcon: true,
    condition: 'Enabled',
    size: 'Large',
    color: 'Blue',
    title: 'Button',
  },
  // NOTE(Jayden): onClick같은 경우는 argsType을 사용해야 test시에도 사용할 수 있다.
  argTypes: {
    onClick: {
      action: 'clicked',
    },
  },
};
