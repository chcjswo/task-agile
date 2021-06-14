import {createLocalVue, mount} from '@vue/test-utils';
import RegisterPage from "@/views/RegisterPage";
import VueRouter from "vue-router";

const localVue = createLocalVue();
localVue.use(VueRouter);
const router = new VueRouter();

jest.mock('@/service/registration');

describe('RegisterPage.vue', () => {
  let wrapper;
  let fieldUsername;
  let filedEmailAddress;
  let fieldPassword;
  let buttonSubmit;

  beforeEach(() => {
    wrapper = mount(RegisterPage, {
      localVue,
      router
    });
    fieldUsername = wrapper.find('#username');
    filedEmailAddress = wrapper.find('#emailAddress');
    fieldPassword = wrapper.find('#password');
    buttonSubmit = wrapper.find('form button[type="submit"]');
  });

  afterAll(() => {
    jest.restoreAllMocks();
  });

  it('should render correct contents', () => {
    expect(wrapper.find('.logo').attributes().src).toEqual(
      '/static/images/logo.png');
    expect(wrapper.find('.tagline').text()).toEqual(
      'Open source task management tool');
    expect(fieldUsername.element.value).toEqual('');
    expect(filedEmailAddress.element.value).toEqual('');
    expect(fieldPassword.element.value).toEqual('');
    expect(buttonSubmit.text()).toEqual('Create Account');
  });

  it('should contain data model with initial values', () => {
    expect(wrapper.vm.form.username).toEqual('');
    expect(wrapper.vm.form.emailAddress).toEqual('');
    expect(wrapper.vm.form.password).toEqual('');
  });

  it('should have form inputs bound with data model', () => {
    const username = 'tony';
    const emailAddress = 'test@test.com';
    const password = '12341234';

    wrapper.vm.form.username = username;
    wrapper.vm.form.emailAddress = emailAddress;
    wrapper.vm.form.password = password;
    expect(fieldUsername.element.value).toEqual(username);
    expect(filedEmailAddress.element.value).toEqual(emailAddress);
    expect(fieldPassword.element.value).toEqual(password);
  });

  it('should have form submit event handler "submitForm"', () => {
    const stub = jest.fn();
    wrapper.setMethods({submitForm: stub});
    buttonSubmit.trigger('submit');
    expect(stub).toBeCalled();
  });

  it('should register when it is a new user', () => {
    const stub = jest.fn();
    wrapper.vm.$router.push = stub;
    wrapper.vm.form.username = 'test';
    wrapper.vm.form.emailAddress = 'test@test.com';
    wrapper.vm.form.password = 'test';
    wrapper.vm.submitForm();
    wrapper.vm.$nextTick(() => {
      expect(stub).toHaveBeenCalledWith({name: 'LoginPage'});
    });
  });

  it('should fail when it is not a new user', () => {
    wrapper.vm.form.emailAddress = 'chcjswo@test.com';
    expect(wrapper.find('.failed').isVisible()).toBe(false);
    wrapper.vm.submitForm();
    wrapper.vm.$nextTick(() => {
      expect(wrapper.find('.failed').isVisible()).toBe(true);
    });
  });

});
